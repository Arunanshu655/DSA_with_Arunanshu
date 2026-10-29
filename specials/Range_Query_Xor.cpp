vector<int> segT;

int build(int idx, int l, int r, vector<int>& e) {
    if (l == r) {
        return segT[idx] = e[l];
    }

    int mid = l + (r - l) / 2;

    int left = build(2 * idx + 1, l, mid, e);
    int right = build(2 * idx + 2, mid + 1, r, e);

    return segT[idx] = left ^ right;
}

int get(int idx, int l, int r, int ql, int qr) {
    // No overlap
    if (r < ql || l > qr)
        return 0;

    // Complete overlap
    if (ql <= l && r <= qr)
        return segT[idx];

    int mid = l + (r - l) / 2;

    return get(2 * idx + 1, l, mid, ql, qr) ^
           get(2 * idx + 2, mid + 1, r, ql, qr);
}

void update(int idx, int l, int r, int pos, int val) {
    if (l == r) {
        segT[idx] = val;
        return;
    }

    int mid = l + (r - l) / 2;

    if (pos <= mid)
        update(2 * idx + 1, l, mid, pos, val);
    else
        update(2 * idx + 2, mid + 1, r, pos, val);

    segT[idx] = segT[2 * idx + 1] ^ segT[2 * idx + 2];
}
