#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node* next;
} node;

node* init_head(int);
node* create_node(int, node*, node*);
void print_list(node*);
void insert_head(int, node*);
void insert_tail(int, node*);
void insert_at(int, int, node*);
void remove_head(node*);
void remove_tail(node*);
void remove_at(int, node*);
int delete_node(node*, node*);
void delete_list(node*);

// Create the head of Linked List.
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
void print_list(node* head) {
    node* current = head;
    while(current != NULL) {
        printf("%d -> ", current->value);
        current = current->next;
    }
    printf("NULL\n");
}

// Adds node with given data at start of Linked List.
void insert_head(int data, node* head) {
    if (head == NULL) {
        return;
    }
    node* next = create_node(head->value, head, head->next);
    head->value = data;
    head->next = next;
}

// Adds node with given data at end of Linked List.
void insert_tail(int data, node* head) {
    if (head == NULL) {
        return;
    } else if (head->next == NULL) {
        create_node(data, head, NULL);
        return;
    }
    node* current = head;
    while (current->next != NULL) {
        current = current->next;
    }
    create_node(data, current, NULL);
}

// Adds item at given index from Linked List. If out of bounds, nothing is added.
void insert_at(int index, int data, node* head) {
    if (head == NULL) {
        return;
    }
    node* current = head;
    for (int i = 0; i < index-1; i++) {
        if (current->next == NULL) {
            return;
        }
        current = current->next;
    }
    if (index == 0) {
        node* next = create_node(head->value, head, head->next);
        head->value = data;
        head->next = next;
    } else {
        create_node(data, current, current->next);
    }
}

// Removes item at beginning of Linked List.
void remove_head(node* head) {
    if (head == NULL) {
        return;
    } else if (head->next == NULL) {
        delete_list(head);
    } else {
        int oldData = delete_node(head, head->next->next);
        head->value = oldData;
    }
}

// Removes item at end of Linked List.
void remove_tail(node* head) {
    node* current = head;
    if (head == NULL) {
        return;
    } else if (head->next == NULL) {
        delete_list(head);
        return;
    }
    while (current->next->next != NULL) {
        current = current->next;
    }
    delete_node(current, current->next->next);
}

// Removes item at given index from Linked List. If out of bounds, nothing is removed.
void remove_at(int index, node* head) {
    node* current = head;
    if (head == NULL) {
        return;
    }
    for (int i = 0; i < index-1; i++) {
        if (current->next == NULL) {
            return;
        }
        current = current->next;
    }
    if (index == 0) {
        if (head->next == NULL) {
            delete_list(head);
        } else {
            int oldData = delete_node(head, head->next->next);
            head->value = oldData;
        }
    } else {
        if (current->next == NULL) {
            return;
        }
        delete_node(current, current->next->next);
    }
}

// Helper method to delete given node from Linked List, frees the memory, and returns value of deleted node.
int delete_node(node* current, node* next) {
    node* old = current->next;
    int oldValue = old->value;
    current->next = next;
    free(old);
    return oldValue;
}

// Deletes entire Linked List from memory.
void delete_list(node* head) {
    node* current = head;
    node* next = NULL;
    while(current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }
}

int main() {
    node* head = init_head(5);
    insert_tail(20, head);
    insert_tail(25, head);
    insert_tail(27, head);
    insert_head(50, head);
    print_list(head);
    insert_at(4, 30, head);
    print_list(head);
    remove_head(head);
    print_list(head);
    remove_tail(head);
    print_list(head);
    remove_at(1, head);
    print_list(head);
    delete_list(head);
    head = init_head(5);
    insert_tail(20, head);
    insert_head(99, head);
    print_list(head);
    delete_list(head);
}
