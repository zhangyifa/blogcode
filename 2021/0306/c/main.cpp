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
 * 是否有环
 * @param head 头结点
 * @return 是否有环
 */
bool hasCycle(List head) {
    PtrToNode slow = head;
    PtrToNode fast = head;
    while (fast != NULL && fast->Next != NULL) {
        slow = slow->Next;
        fast = fast->Next->Next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
}

int main() {
    // 构造数据
    List head = (List) malloc(sizeof(struct Node));
    head->Data = 1;

    List twoNode = (List) malloc(sizeof(struct Node));
    twoNode->Data = 2;
    head->Next = twoNode;

    List thirdNode = (List) malloc(sizeof(struct Node));
    thirdNode->Data = 3;
    thirdNode->Next = NULL;
    twoNode->Next = thirdNode;

    List fourNode = (List) malloc(sizeof(struct Node));
    fourNode->Data = 4;
    fourNode->Next = thirdNode;
    thirdNode->Next = fourNode;

    // 是否有环
    bool cycle = hasCycle(head);
    if (cycle) {
        printf("YES");
    } else {
        printf("NO");
    }

    return 0;
}