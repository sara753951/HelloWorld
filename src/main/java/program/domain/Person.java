package program.domain;

/**
 * Created by yanxinming on 2020/3/11
 */
public class Person {
    private Integer idx;
    private String name;
    private String className;

    public Person(Integer idx, String name, String className) {
        this.idx = idx;
        this.name = name;
        this.className = className;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
