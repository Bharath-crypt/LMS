package LibraryManagementSystem;

class Teacher extends User {
    public Teacher(int id, String name) {
        super(id, name);
    }

    public int getLimit() {
        return 5;
    }
}