#include <stdio.h>
#include <assert.h>

int lower_bound(int *a, int start, int end, int target) {
    int left = 0, right = end;
    while(left < right) {
        int mid = (right - left) / 2 + left;
        if(a[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid;
        }
    }
    if(left != end && a[left] == target) {
        return left;
    }
    return -1;
}

int upper_bound(int *a, int start, int end, int target) {
    int left = start, right = end;
    while(left < right) {
        int mid = (right - left) / 2 + left;
        if(a[mid] <= target) {
            left = mid + 1;
        }
        else {
            right = mid;
        }
    }
    if(-1 < left-1 < end && a[left-1] == target) {
        return left;
    }
    return -1;
}

int main(void) {
    int a[] = {1, 1, 2};
    int n = 3;
    assert(lower_bound(a, 0, n, 1) == 0);
    assert(lower_bound(a, 0, n, 2) == 2);
    assert(lower_bound(a, 0, n, 3) == -1);
    a[0] = 0;
    assert(lower_bound(a, 0, n, 1) == 1);

    assert(upper_bound(a, 0, n, 1) == 2);
    int b[] = {1, 1, 2, 3};
    n = 4;
    assert(lower_bound(b, 0, n, 1) == 0);
    assert(upper_bound(b, 0, n, 1) == 2);

    int delta = 2;
    int pairs = 0;
    for(int i = 0; i < n; i++) {
        int target = b[i] + delta;
        int left = lower_bound(b, i + 1, n, target);
        int right = upper_bound(b, i + 1, n, target);
        pairs = pairs + right - left; 
    }
    printf("pairs: %d\n", pairs);
} 
