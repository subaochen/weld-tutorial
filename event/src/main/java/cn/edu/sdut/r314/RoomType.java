package cn.edu.sdut.r314;

/**
 *
 * @author subaochen
 */
public enum RoomType {
    ONE("单人间"), TWO("双人间"), THREE("三人间"), FOUR("四人间");

    private String label;

    private RoomType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
