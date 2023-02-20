#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node* next;
} node;

void print(node* head) {
    node* next = head;
    while(next != NULL) {
        printf("%d -> ", next->value);
        next = next->next;
    }
    printf("NULL\n");
}

void tailInsert(int data, node* head) {
    node* next = head;
    if (head->value == NULL) {
        head->value = data;
        return;
    }
    while (next->next != NULL) {
        next = next->next;
    }
    node* link = (node*)malloc(sizeof(node));
    link->value = data;
    link->next = NULL;
    next->next = link;
}

int main() {
    node *head = NULL;
    head = (node*)malloc(sizeof(node));
    tailInsert(20, head);
    tailInsert(25, head);
    tailInsert(27, head);
    print(head);
}
