package gob.hidalgo.curso.database.sysoppf;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import gob.hidalgo.curso.utils.EntityObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("TblOficioEO")
public class TblOficioEO extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String num_oficio;
	private String remitente;
	private String desc_asunto;
	private Date fecha_solicitud;
	private String desc_observaciones;
	private Date fec_registro;
	private String num_turno_orig;
	private Date fecha_acuse;

	// Messages
	// Messages @NotNull
	@NotNull(message = "Ingresar el A�o")
	private Integer anio;

	@NotNull(message = "Ingresar el �rea")
	private Integer id_area;

	@NotNull(message = "Ingresar el Usuario")
	private Integer id_usuario_sol;

	// FECHA_BUSQUEDA
	private Date fechaInicio;
	private Date fechaFinal;

	public TblOficioEO() {
		super();
	}
}
