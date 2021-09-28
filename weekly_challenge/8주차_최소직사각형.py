def solution(sizes):
    answer = 0
    n = len(sizes)
    inside_out_sizes = []
    for i in range(n):
        inside_out_sizes.append([sizes[i][1], sizes[i][0]])
    maxw, maxh = 0, 0
    for i in range(n):
        w, h = sizes[i]
        i_o_w, i_o_h = inside_out_sizes[i]
        if (w <= maxw and h <= maxh) or (i_o_w <= maxw and i_o_h <= maxh):
            continue
        else:
            if max(maxw, w) * max(maxh, h) > max(maxw, i_o_w) * max(maxh, i_o_h):
                maxw, maxh = max(maxw, i_o_w), max(maxh, i_o_h)
            else:
                maxw, maxh = max(maxw, w), max(maxh, h)
    answer = maxw * maxh
    return answer