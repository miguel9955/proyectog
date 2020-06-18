package uts.edu.dae.controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import uts.edu.dae.entidades.util.JsfUtil;
import uts.edu.dae.entidades.util.JsfUtil.PersistAction;
import uts.edu.dae.ejb.AspiranteFacade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.model.file.UploadedFile;
import uts.edu.dae.ejb.UsuarioFacade;
import uts.edu.dae.entidades.Aspirante;
import uts.edu.dae.entidades.Usuario;

@ManagedBean(name = "aspiranteController")
@SessionScoped
public class AspiranteController implements Serializable {
    @EJB
    private AspiranteFacade aspiranteFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private uts.edu.dae.ejb.AspiranteFacade ejbFacade;
    private List<Aspirante> items = null;
    private Aspirante selected;
    private UploadedFile file;
    private String destination;
    private String hojadevidaAspirante;
    private String tipodocumentoAspirante;
    private int idAspirante;
    private Integer documentoAspirante;
    private String nombresApitante;
    private String apellidosAspirante;
    private Date fechaAspirante;
    private String carreraAspirante;
    private String semestreAspirante;
    private String telefonoAspirante;
    private String correoAspirante;
    private Usuario usuario;
    private String contraseña;
    private String tipoUsuario;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHojadevidaAspirante() {
        return hojadevidaAspirante;
    }

    public void setHojadevidaAspirante(String hojadevidaAspirante) {
        this.hojadevidaAspirante = hojadevidaAspirante;
    }

    public String getTipodocumentoAspirante() {
        return tipodocumentoAspirante;
    }

    public void setTipodocumentoAspirante(String tipodocumentoAspirante) {
        this.tipodocumentoAspirante = tipodocumentoAspirante;
    }

    public int getIdAspirante() {
        return idAspirante;
    }

    public void setIdAspirante(int idAspirante) {
        this.idAspirante = idAspirante;
    }

    public Integer getDocumentoAspirante() {
        return documentoAspirante;
    }

    public void setDocumentoAspirante(Integer documentoAspirante) {
        this.documentoAspirante = documentoAspirante;
    }

    public String getNombresApitante() {
        return nombresApitante;
    }

    public void setNombresApitante(String nombresApitante) {
        this.nombresApitante = nombresApitante;
    }

    public String getApellidosAspirante() {
        return apellidosAspirante;
    }

    public void setApellidosAspirante(String apellidosAspirante) {
        this.apellidosAspirante = apellidosAspirante;
    }

    public Date getFechaAspirante() {
        return fechaAspirante;
    }

    public void setFechaAspirante(Date fechaAspirante) {
        this.fechaAspirante = fechaAspirante;
    }

    public String getCarreraAspirante() {
        return carreraAspirante;
    }

    public void setCarreraAspirante(String carreraAspirante) {
        this.carreraAspirante = carreraAspirante;
    }

    public String getSemestreAspirante() {
        return semestreAspirante;
    }

    public void setSemestreAspirante(String semestreAspirante) {
        this.semestreAspirante = semestreAspirante;
    }

    public String getTelefonoAspirante() {
        return telefonoAspirante;
    }

    public void setTelefonoAspirante(String telefonoAspirante) {
        this.telefonoAspirante = telefonoAspirante;
    }

    public String getCorreoAspirante() {
        return correoAspirante;
    }

    public void setCorreoAspirante(String correoAspirante) {
        this.correoAspirante = correoAspirante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public AspiranteController() {
    }

    public Aspirante getSelected() {
        return selected;
    }

    public void setSelected(Aspirante selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AspiranteFacade getFacade() {
        return ejbFacade;
    }

    public Aspirante prepareCreate() {
        selected = new Aspirante();
        initializeEmbeddableKey();
        return selected;
    }
    public void createU(){
           this.usuario.setCorreoUsuario(this.selected.getCorreoAspirante());
           this.usuario.setContraseña(contraseña);
           tipoUsuario="ASPIRANTE";
           this.usuario.setTipoUsuario("ASPIRANTE");
        try {
            this.usuarioFacade.create(usuario);
            this.usuario = new Usuario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AspiranteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AspiranteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AspiranteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Aspirante> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Aspirante> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Aspirante> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Aspirante.class)
    public static class AspiranteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AspiranteController controller = (AspiranteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "aspiranteController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Aspirante) {
                Aspirante o = (Aspirante) object;
                return getStringKey(o.getDocumentoAspirante());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Aspirante.class.getName()});
                return null;
            }
        }

    }
    public void nuevoD(){
        if (upload()) {
           selected.setHojadevidaAspirante(Constantes.SEPARADOR +destination);
           createU();
           create();
           
           
           
           destination="";
        }
    }
    public Boolean upload(){
        try {
            destination = Constantes.URL + selected.getIdAspirante();
            System.out.println("destination ="+destination);
            File folder = new File(FacesUtils.getPath()+destination);
            if(!folder.exists()){
                folder.mkdirs();
            
            }
            copyFile(getFile().getFileName(),getFile().getInputStream());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public void copyFile(String filename, InputStream in){
        try {
            destination = destination + Constantes.SEPARADOR + filename;
            System.out.println("destination"+destination);
            OutputStream out = new FileOutputStream(new File(FacesUtils.getPath()+destination));
            int read= 0;
            byte[] bytes = new byte[1024];
            while ((read =in.read(bytes)) !=-1) {                
                out.write(bytes,0,read);
                
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("erro_cargar_doc"));
        }
    }
    @PostConstruct
    public void init(){
     selected = new Aspirante();
     usuario = new Usuario();
    }

}
