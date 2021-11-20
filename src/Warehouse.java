public class Warehouse {
    private final String WarehouseId;
    private final String WarehouseName;
    private final String WarehouseAdress;

    public Warehouse(String warehouseId, String warehouseName, String warehouseAdress) {
        WarehouseId = warehouseId;
        WarehouseName = warehouseName;
        WarehouseAdress = warehouseAdress;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "WarehouseId='" + WarehouseId + '\'' +
                ", WarehouseName='" + WarehouseName + '\'' +
                ", WarehouseAdress='" + WarehouseAdress + '\'' +
                '}';
    }

    public String getWarehouseId() {
        return WarehouseId;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public String getWarehouseAdress() {
        return WarehouseAdress;
    }
}
