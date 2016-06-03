package bo.edu.ucbcba.Taller.model;

/**
 * Created by Rebeca on 18/05/2016.
 */
import bo.edu.ucbcba.Taller.exceptions.ValidationException;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50)
    private int ci;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String date;

    @Column(length = 100)
    private int costo;

    @Lob
    @Column(length = 500)
    private String descrip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null)
            throw new ValidationException("Null title");
        if (nombre.isEmpty())
            throw new ValidationException("Title can't be empty");
        if (nombre.length() > 255)
            throw new ValidationException("Title is too long");
        this.nombre = nombre;
    }


    public String getDate() {
        /*Calendar ahoraCal = Calendar.getInstance();
        System.out.println(ahoraCal.getClass());
        ahoraCal.set(2016, 5, 18);
        return date="2016,5,18";*/
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        if (descrip == null)
            throw new ValidationException("Null title");
        if (descrip.isEmpty())
            throw new ValidationException("Title can't be empty");
        if (descrip.length() > 255)
            throw new ValidationException("Title is too long");
        this.descrip = descrip;
    }

}
