package com.uniandes.stampidia.utilities;

public class Resultado {

	private Object resultado;
	
	private int numPaginas;
	
	private long totalObjetos;
	
	private String mensajeAccion;
	
	private String mensajeConsulta;

    private Status estado;

    public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public long getTotalObjetos() {
		return totalObjetos;
	}

	public void setTotalObjetos(long totalObjetos) {
		this.totalObjetos = totalObjetos;
	}

	public String getMensajeAccion() {
		return mensajeAccion;
	}

	public void setMensajeAccion(String mensajeAccion) {
		this.mensajeAccion = mensajeAccion;
	}

	public String getMensajeConsulta() {
		return mensajeConsulta;
	}

	public void setMensajeConsulta(String mensajeConsulta) {
		this.mensajeConsulta = mensajeConsulta;
	}

    public Status getEstado() {
        return estado;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }
}
