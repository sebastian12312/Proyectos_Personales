/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class DetalleComprasUsuario extends ComprasUsuario{
  private String CodigoProducto;
  private String NombreProducto;
  private String DescripcionProducto;
  private int CantidadCompra;
  private double PrecioProducto;
  private double SubTotalDetalles;
  private double DescuentoDetalle;

    public DetalleComprasUsuario() {
    }

    public DetalleComprasUsuario(String CodigoProducto, String NombreProducto, String DescripcionProducto, int CantidadCompra, double PrecioProducto, double SubTotalDetalles, double DescuentoDetalle, String CodigoCompra, String codigoUsuario, double SubTotal, double DescuentoCompra, double IGVCompra, double PrecioFInal, String FechaCompra, String EstadoCompra) {
        super(CodigoCompra, codigoUsuario, SubTotal, DescuentoCompra, IGVCompra, PrecioFInal, FechaCompra, EstadoCompra);
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.CantidadCompra = CantidadCompra;
        this.PrecioProducto = PrecioProducto;
        this.SubTotalDetalles = SubTotalDetalles;
        this.DescuentoDetalle = DescuentoDetalle;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public int getCantidadCompra() {
        return CantidadCompra;
    }

    public void setCantidadCompra(int CantidadCompra) {
        this.CantidadCompra = CantidadCompra;
    }

    public double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    public double getSubTotalDetalles() {
        return SubTotalDetalles;
    }

    public void setSubTotalDetalles(double SubTotalDetalles) {
        this.SubTotalDetalles = SubTotalDetalles;
    }

    public double getDescuentoDetalle() {
        return DescuentoDetalle;
    }

    public void setDescuentoDetalle(double DescuentoDetalle) {
        this.DescuentoDetalle = DescuentoDetalle;
    }
  
    
    
}
