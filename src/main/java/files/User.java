package files;

public class User {
    private String name, surname;
    private int age;
    private String parentCategory;

 /*   public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

    }*/
public void setParentCategory(String parentCategory){
        this.parentCategory=parentCategory;
}

public String getParentCategory(){
        return parentCategory;
}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", ParentCategory='" + parentCategory + '\'' +
                '}';
    }
}
