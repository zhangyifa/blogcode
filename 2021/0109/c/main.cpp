#include <stdio.h>
#include <stdlib.h>

/**
 * 定义结点
 */
typedef int ElementType;
typedef struct Node *PtrToNode;
struct Node {
    ElementType Data;
    PtrToNode Next;
};
typedef PtrToNode List;

/**
 * 反转单链表
 * @param head 头结点
 * @return 反转过后的头结点
 */
List reverseList(List head){
    if (head == null || head->next == null) {
        return head;
    }
    ListNode p = reverseList(head->next);
    head->next->next = head;
    head->next = null;
    return p;
}

/**
 * 打印单链表
 * @param head 头结点
 */
void print(List head) {
    List tmp = head;
    while (tmp) {
        printf("%d -> ", tmp->Data);
        tmp = tmp->Next;
    }
    printf("NULL\n");
}

int main() {
    // 构造数据
    List head = (List)malloc(sizeof(struct Node));
    head->Data = 1;

    List twoNode = (List)malloc(sizeof(struct Node));
    twoNode->Data = 2;
    head->Next = twoNode;

    List thirdNode = (List)malloc(sizeof(struct Node));
    thirdNode->Data = 3;
    thirdNode->Next = NULL;
    twoNode->Next = thirdNode;

    printf("before reverse\n");
    print(head);
    // 反转
    head = reverseList(head);
    printf("after reverse\n");
    print(head);
    return 0;
}