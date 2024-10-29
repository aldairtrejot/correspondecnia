package gob.hidalgo.curso.database.sysoppf;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import gob.hidalgo.curso.utils.EntityObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("TblturnoEO")
public class TblturnoEO  extends EntityObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String num_oficio;
	private Date fecha_reg;
	private String num_turno;
	private String cargo_remitente;
	private String lugar;
	private String asunto;
	private String bturnosf;
	private String desc_conclusion;
	private String desc_observacion;
	private String desc_termino;
	private String desc_boletin;
	private String desc_ejecucion;
	private Integer num_original;
	private Integer num_fojas;
	private Integer num_copia;
	private Date fec_vencimiento;
	private Integer num_tomos;
	private String turno_sin;
	private String rfc;
	
	
	//Message @NotNull
	@NotBlank (message = "Ingrese el Remitente")
	private String remitente;
	
	@NotNull (message = "Ingrese el A�o")
	private Integer anio_oficio;
	
	@NotNull (message = "Ingresar el Area")
	private Integer id_area_atension;
	
	@NotNull (message = "Ingrese el Usuario")
	private Integer id_usuario_resp;
	
	@NotNull (message = "Ingrese el Estatus")
	private Integer id_estatus;

	@NotNull (message = "Tipo Documento")
	private String num_expediente_ori;
	
	@NotNull (message = "Abogado Responsable")
	private Integer id_enc;
	
	@NotBlank (message = "Fecha Solicitud")
	private Date fec_registro;
	
	//FECHA_BUSQUEDA
	private Date fechaInicio;
	private Date fechaFinal;
	
	public TblturnoEO() {
		super();
	}
}
