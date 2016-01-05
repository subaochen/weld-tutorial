package cn.edu.sdut.r314;

public enum RoomStatus {
    CHECKED_IN("已入住"), // 客户已入住状态
    AVAILABLE("空闲"); // 空闲状态

    private String label;

    private RoomStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
