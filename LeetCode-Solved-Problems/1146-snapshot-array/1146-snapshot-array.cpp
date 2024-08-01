class SnapshotArray {
public:
    int curr_snap=0;
    unordered_map<int,map<int,int>>mp;
    SnapshotArray(int length) {}
    
    void set(int index, int val) {
        mp[index][curr_snap]=val;
    }
    
    int snap() {
        return curr_snap++;
    }
    
    int get(int index, int snap_id) {
        auto it = mp[index].upper_bound(snap_id);
        return it==begin(mp[index])? 0: prev(it)->second;
    }
};

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray* obj = new SnapshotArray(length);
 * obj->set(index,val);
 * int param_2 = obj->snap();
 * int param_3 = obj->get(index,snap_id);
 */