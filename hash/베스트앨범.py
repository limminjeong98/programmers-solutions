def solution(genres, plays):
    answer = []
    gdict = {}
    for genre in genres:
        gdict[genre] = gdict.get(genre, 0) + 1
    # print(gdict)
    songs = list(zip(genres, plays))
    arr = {}
    for genre in gdict.keys():
        # print(genre)
        if genre not in arr:
            arr[genre] = []
        idx = 0
        # print(songs)
        for song in songs:
            # print(song[0], genre)
            if song[0] == genre:
                arr[genre].append([idx, song[1]])
            idx += 1

    for genre in arr.keys():
        arr[genre].sort(key=lambda x: (-x[1], x[0]))
    # print(arr)
    genretotal = {}
    for genre in arr.keys():
        genretotal[genre] = 0
        for item in arr[genre]:
            genretotal[genre] += item[1]
    # print(genretotal)
    totalvalue = sorted(genretotal.values(), reverse=True)
    # print(totalvalue)
    i = 0
    while i < len(gdict):
        for genre in arr.keys():
            if genretotal[genre] == totalvalue[i]:
                if len(arr[genre]) == 1:
                    answer.append(arr[genre][0][0])
                else:
                    answer.append(arr[genre][0][0])
                    answer.append(arr[genre][1][0])
                i += 1
                break
    # for genre in 
    #     answer.append(arr[genre][0])
    return answer