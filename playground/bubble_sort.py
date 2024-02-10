import random

def bubble(nums):
    for j in range(len(nums)-1):
        for i in range(1, len(nums)-j):
            if nums[i] < nums[i-1]:
                nums[i-1], nums[i] = nums[i], nums[i-1]
    print(id(nums))
    return nums

if __name__ == '__main__':
    input = [random.randint(0, 100) for _ in range(20)]
    # assert(id(bubble(input)) == id(input))
    bubble(input)
    print(id(input))