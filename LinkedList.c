#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node* next;
} node;

node* initHead(int data) {
    node* head = NULL;
    head = (node*)malloc(sizeof(node));
    head->value = data;
    head->next = NULL;
    return head;
}

void print(node* head) {
    node* next = head;
    while(next->next != NULL) {
        printf("%d -> ", next->value);
        next = next->next;
    }
    printf("NULL\n");
}

void tailInsert(int data, node* head) {
    node* next = head;
    if (head == NULL) {
        return;
    }
    int i = 0;
    while (next->next != NULL) {
        next = next->next;
    }
    node* link = (node*)malloc(sizeof(node));
    link->value = data;
    link->next = NULL;
    next->next = link;
}

int main() {
    node *head = initHead(5);
    tailInsert(20, head);
    tailInsert(25, head);
    tailInsert(27, head);
    print(head);
}
