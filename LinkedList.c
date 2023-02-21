#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node* next;
} node;

node* init_head(int data) {
    node* head = NULL;
    head = (node*)malloc(sizeof(node));
    head->value = data;
    head->next = NULL;
    return head;
}

node* createNode(int data, node* current, node* next) {
    node* newNode = (node*)malloc(sizeof(node));
    newNode->value = data;
    newNode->next = next;
    current->next = newNode;
    return newNode;
}

void print(node* head) {
    node* current = head;
    while(current->next != NULL) {
        printf("%d -> ", current->value);
        current = current->next;
    }
    printf("NULL\n");
}

void head_insert(int data, node* head) {
    if (head == NULL) {
        return;
    }
    node* next = createNode(head->value, head, head->next);
    head->value = data;
    head->next = next;
}

void tail_insert(int data, node* head) {
    if (head == NULL) {
        return;
    }
    if (head->next == NULL) {
        createNode(data, head, NULL);
    }
    node* current = head;
    while (current->next != NULL) {
        current = current->next;
    }
    createNode(data, current, NULL);
}

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
    tail_insert(20, head);
    tail_insert(25, head);
    tail_insert(27, head);
    head_insert(50,head);
    print(head);
    delete_list(head);
    head = init_head(5);
    tail_insert(20, head);
    head_insert(99, head);
    print(head);
    delete_list(head);
}
