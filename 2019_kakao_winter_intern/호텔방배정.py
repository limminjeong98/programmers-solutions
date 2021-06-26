import sys
sys.setrecursionlimit(1000000000)

def find_empty_room(now, rooms):
    if now not in rooms:
        rooms[now] = now + 1
        return now
    empty = find_empty_room(rooms[now], rooms)
    rooms[now] = empty + 1
    return empty

def solution(k, room_number):
    answer = []
    rooms = dict()
    for room in room_number:
        empty_room = find_empty_room(room, rooms)
        answer.append(empty_room)
    return answer