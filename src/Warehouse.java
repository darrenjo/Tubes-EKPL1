public class Warehouse {
    private final String WarehouseID;
    private final String WarehouseName;
    private final String WarehouseAddress;

    public Warehouse(String warehouseID, String warehouseName, String warehouseAddress) {
        WarehouseID = warehouseID;
        WarehouseName = warehouseName;
        WarehouseAddress = warehouseAddress;
    }

    public String getWarehouseId() {
        return WarehouseID;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public String getWarehouseAddress() {
        return WarehouseAddress;
    }
}
