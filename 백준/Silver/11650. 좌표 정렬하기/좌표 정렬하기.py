# 점 개수 입력
point = int(input())

# 좌표 저장 리스트
points = []

# 좌표 입력
for _ in range(point):
    # x,y 좌표
    y, x = map(int,input().split())
    points.append([y,x])

# 좌표 정렬
points.sort()

# 결괏값
for pt1, pt2 in points:
    print(pt1,pt2)