import sys
input = sys.stdin.readline

nums = list(map(int, input().split()))

def check(num):
    if num == 1:
        for i in range(1, len(nums)):
            if nums[i] - nums[i-1] != 1:
                print("mixed")
                return
        print("ascending")
        return
    elif num == 8:
        for i in range(1, len(nums)):
            if nums[i-1] - nums[i] != 1:
                print("mixed")
                return
        print("descending")
        return
    else:
        print("mixed")
        return

check(nums[0])