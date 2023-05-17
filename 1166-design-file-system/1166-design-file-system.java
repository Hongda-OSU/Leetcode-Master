class FileSystem {
    private HashMap<String, Integer> paths;

    public FileSystem() {
        paths = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if (path.isEmpty() || (path.length() == 1 && path.equals("/")) || paths.containsKey(path))
            return false;
        int index = path.lastIndexOf("/");
        String parent = path.substring(0, index);
        if (parent.length() > 1 && !paths.containsKey(parent))
            return false;
        paths.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */