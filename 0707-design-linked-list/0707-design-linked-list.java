class MyLinkedList {
    private Item head;
    private Item tail;
    private int length;

    public int get(int index) {
        Item result = getItemByIndex(index);
        if (result != null) return result.val;
        return -1;
    }

    public void addAtHead(int val) {
        if (length > 0) {
            Item temp = head;
            head = new Item(val);
            head.next = temp;
            temp.prev = head;
        } else {
            head = new Item(val);
            tail = head;
        }
        length++;
    }

    public void addAtTail(int val) {
        if (length > 0) {
            Item temp = tail;
            tail = new Item(val);
            tail.prev = temp;
            temp.next = tail;
        } else {
            tail = new Item(val);
            head = tail;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) return; // index validation
        if (index == 0) addAtHead(val);
        else if (index == length) addAtTail(val);
        else {
            Item result = getItemByIndex(index);
            if (result != null) {
                Item temp = new Item(val);
                temp.prev = result.prev;
                result.prev.next = temp;
                temp.next = result;
                result.prev = temp;
                length++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return; // index validation
        if (index == 0) {
            if (length == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                if (length > 2) head.next.prev = head;
            }
            length--;
        } else if (index == (length - 1)) {
            tail = tail.prev;
            if (length > 2) tail.prev.next = tail;
            length--;
        } else {
            Item result = getItemByIndex(index);
            if (result != null) {
                result.prev.next = result.next;
                result.next.prev = result.prev;
                length--;
            }
        }
    }

    private Item getItemByIndex(int index) {
        if (length > 0 && index < length) {
            if (index == 0) return head;
            if (index == length - 1) return tail;
            Item result;
            // we choose how to get to the desired element faster. Begin with head or tail
            if (index > (length / 2)) {
                result = tail;
                for (int i = length - 1; i > index; i--) {
                    result = result.prev;
                }
            } else {
                result = head;
                for (int i = 1; i <= index; i++) {
                    result = result.next;
                }

            }
            return result;
        }
        return null;
    }

    public int getLength() {
        return length;
    }
    // subclass element of linked-list
    private static class Item {
        public Item(int val) {
            this.val = val;
        }

        int val;
        Item next;
        Item prev;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */