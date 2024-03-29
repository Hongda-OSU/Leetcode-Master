class FileSystem {
    class File {
        boolean isFile = false;
        HashMap<String, File> files = new HashMap<>();
        String content = "";
    }
    public File root;

    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        File t = root;
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                t = t.files.get(d[i]);
            }
            if (t.isFile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List<String> resFiles = new ArrayList<>(t.files.keySet());
        Collections.sort(resFiles);
        return resFiles;
    }
    
    public void mkdir(String path) {
        File t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.files.containsKey(d[i])) {
                t.files.put(d[i], new File());
            }
            t = t.files.get(d[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++)
            t = t.files.get(d[i]);
        if (!t.files.containsKey(d[d.length - 1])) 
            t.files.put(d[d.length - 1], new File());
        t = t.files.get(d[d.length - 1]);
        t.isFile = true;
        t.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) 
            t = t.files.get(d[i]);
        return t.files.get(d[d.length - 1]).content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */