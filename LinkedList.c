// Jason Yau Feb 2023
// Operations:
// Head Insert: O(1)
// Tail Insert: O(1)
// Index Insert: O(n)
// Head Remove: O(1)
// Tail Remove: O(n)
// Index Remove: O(n)
// Reverse: O(n)
// Print: O(n)
// Size: O(1)

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct node {
    int value;
    struct node* next;
} node;

typedef struct linked_list {
    node* head;
    node* tail;
    int size;
} linked_list;

linked_list* init_list(void);
node* init_head(int);
node* create_node(int, node*, node*);
void print_list(linked_list*);
void reverse_list(linked_list*);
void insert_head(int, linked_list*);
void insert_tail(int, linked_list*);
void insert_at(int, int, linked_list*);
int remove_head(linked_list*);
int remove_tail(linked_list*);
int remove_at(int, linked_list*);
int list_size(linked_list*);
int delete_between(node*, node*);
void delete_list(linked_list*);

// Creates a new Linked List
linked_list* init_list(void) {
    linked_list* list = (linked_list*)malloc(sizeof(linked_list));
    list->head = NULL;
    list->tail = NULL;
    list->size = 0;
    return list;
}

// Helper method to create the head of Linked List.
node* init_head(int data) {
    node* head = NULL;
    head = (node*)malloc(sizeof(node));
    head->value = data;
    head->next = NULL;
    return head;
}

// Helper method to create new node.
node* create_node(int data, node* current, node* next) {
    node* new_node = (node*)malloc(sizeof(node));
    new_node->value = data;
    new_node->next = next;
    current->next = new_node;
    return new_node;
}

// Prints entire Linked List.
void print_list(linked_list* list) {
    node* current = list->head;
    while(current != NULL) {
        printf("%d -> ", current->value);
        current = current->next;
    }
    printf("NULL\n");
}

// Reverses entire Linked List.
void reverse_list(linked_list* list) {
    node* last = NULL;
    node* current = list->head;
    list->tail = current;
    node* next = NULL;
    while(current != NULL) {
        next = current->next;
        current->next = last;
        last = current;
        current = next;
    }
    list->head = last;
}

// Adds node with given data at start of Linked List.
void insert_head(int data, linked_list* list) {
    if (list == NULL) {
        return;
    }
    node* head = init_head(data);
    list->size++;
    if (list->head == NULL) {
        list->head = head;
        list->tail = head;
        return;
    }
    head->next = list->head;
    list->head = head;
}

// Adds node with given data at end of Linked List.
void insert_tail(int data, linked_list* list) {
    if (list == NULL) {
        return;
    } 
    if (list->head == NULL) {
        insert_head(data, list);
        return;
    }
    list->tail = create_node(data, list->tail, NULL);
    list->size++;
}

// Adds item at given index from Linked List. If out of bounds, nothing is added.
void insert_at(int index, int data, linked_list* list) {
    if (list == NULL) {
        return;
    }
    node* current = list->head;
    for (int i = 0; i < index-1; i++) {
        if (current->next == NULL) {
            return;
        }
        current = current->next;
    }
    if (index == 0) {
        insert_head(data, list);
    } else {
        create_node(data, current, current->next);
        list->size++;
    }
}

// Removes item at beginning of Linked List.
int remove_head(linked_list* list) {
    if (list == NULL || list->head == NULL) {
        return INT_MIN;
    } else if (list->head->next == NULL) {
        int old_data = list->head->value;
        delete_list(list);
        return old_data;
    } else {
        node* head = list->head;
        int old_data = list->head->value;
        int new_head = delete_between(head, head->next->next);
        list->head->value = new_head;
        list->size--;
        return old_data;
    }
}

// Removes item at end of Linked List.
int remove_tail(linked_list* list) {
    if (list == NULL || list->head == NULL) {
        return INT_MIN;
    } else if (list->head->next == NULL) {
        return remove_head(list);
    }
    node* current = list->head;
    while (current->next->next != NULL) {
        current = current->next;
    }
    list->size--;
    list->tail = current;
    return delete_between(current, NULL);
    
}

// Removes item at given index from Linked List. If out of bounds, nothing is removed.
int remove_at(int index, linked_list* list) {
    if (list == NULL || list->head == NULL) {
        return INT_MIN;
    }
    node* current = list->head;
    for (int i = 0; i < index-1; i++) {
        if (current->next == NULL) {
            return INT_MIN;
        }
        current = current->next;
    }
    if (index == 0) {
        return remove_head(list);
    } else {
        if (current->next == NULL) {
            return INT_MIN;
        } 
        list->size--;
        if (current->next->next == NULL) {
            list->tail = current;
        }
        return delete_between(current, current->next->next);
    }
}

// Returns size of Linked List
int list_size(linked_list* list) {
    return list->size;
}

// Helper method to delete node between two nodes from Linked List, frees the memory, and returns value of deleted node.
int delete_between(node* current, node* next) {
    node* old = current->next;
    int old_value = old->value;
    current->next = next;
    free(old);
    return old_value;
}

// Deletes entire Linked List from memory.
void delete_list(linked_list* list) {
    node* current = list->head;
    node* next = NULL;
    while(current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }
    list->head = NULL;
    list->tail = NULL;
    list->size = 0;
}

int main(void) {
    linked_list* list = init_list();
    insert_at(0, 50, list);
    print_list(list);
    printf("Removed: %d\n", remove_tail(list));
    insert_head(5, list);
    insert_head(10, list);
    insert_head(15, list);
    insert_head(20, list);
    print_list(list);
    insert_tail(89, list);
    insert_tail(25, list);
    insert_at(3, 69, list);
    print_list(list);
    insert_at(6, 99, list);
    print_list(list);
    printf("Size: %d\n", list_size(list));
    printf("Removed: %d\n", remove_tail(list));
    printf("Removed: %d\n", remove_tail(list));
    print_list(list);
    printf("Removed Index 1: %d\n", remove_at(1, list));
    printf("Removed Index 0: %d\n", remove_at(0, list));
    printf("Removed Index 3: %d\n", remove_at(2, list));
    print_list(list);
    insert_head(1, list);
    insert_at(2, 23, list);
    insert_at(3, 27, list);
    insert_tail(999, list);
    print_list(list);
    for(int i = 0; i < 5; i++) {
        printf("Reversed.\n");
        reverse_list(list);
    }
    print_list(list);
    insert_head(1000, list);
    insert_tail(0, list);
    print_list(list);
    printf("Size: %d\n", list_size(list));
    delete_list(list);
    printf("Deleted List.\n");
    print_list(list);
    return 0;
}
