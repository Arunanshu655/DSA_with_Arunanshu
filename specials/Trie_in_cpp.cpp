class Trie {
    bool pres;
    vector<Trie*> neigh;
public:
    Trie() {
        pres = false;
        neigh = vector<Trie*>(26,nullptr);
    }
    
    void insert(string word) {
        int n = word.size();
        Trie* temp = this;
        for(int i = 0 ; i < n ; i++){
            char ch = word[i];
            if(temp->neigh[ch-'a'] == nullptr) temp->neigh[ch-'a'] = new Trie();
            temp = temp->neigh[ch-'a'];
        }
        temp->pres = true;
    }
    
    bool search(string word) {
        int n = word.size();
        Trie* temp = this;
        for(int i = 0 ; i < n ; i++){
            char ch = word[i];
            if(temp->neigh[ch-'a'] == nullptr) return false;
            temp = temp->neigh[ch-'a'];
        }

        return (temp->pres == true);
    }
    
    bool startsWith(string prefix) {
        int n = prefix.size();
        Trie* temp = this;
        for(int i = 0 ; i < n ; i++){
            char ch = prefix[i];
            if(temp->neigh[ch-'a'] == nullptr) return false;
            temp = temp->neigh[ch-'a'];
        }

        return true; 
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
