package centralPacientes.mundo; /**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CentralPacientes {
    // Attributes
    private ArrayList<Paciente> pacientes;
    private ArrayList<String> listaClinicas;

    // Constructor
    public CentralPacientes() {
        pacientes = new ArrayList<>();
        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // Methods
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    public void agregarPacienteAlComienzo(Paciente pac) {
        pacientes.add(0, pac);
    }

    public void agregarPacienteAlFinal(Paciente pac) {
        pacientes.add(pac);
    }

    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        int index = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoExisteException("El paciente con el código especificado no existe.");
        } else {
            pacientes.add(index, pac);
        }
    }

    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        int index = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                index = i + 1;
                break;
            }
        }
        if (index == -1) {
            throw new NoExisteException("El paciente con el código especificado no existe.");
        } else {
            pacientes.add(index, pac);
        }
    }

    public Paciente localizar(int codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == codigo) {
                return paciente;
            }
        }
        return null;
    }

    public void eliminarPaciente(int cod) throws NoExisteException {
        Paciente paciente = null;
        for (Paciente p : pacientes) {
            if (p.darCodigo() == cod) {
                paciente = p;
                break;
            }
        }
        if (paciente == null) {
            throw new NoExisteException("El paciente con el código especificado no existe.");
        } else {
            pacientes.remove(paciente);
        }
    }

    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    public int cantHombres() {
        int count = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.HOMBRE) {
                count++;
            }
        }
        return count;
    }

    public int cantMujeres() {
        int count = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.MUJER) {
                count++;
            }
        }
        return count;
    }

    public String metodo4() {
        Map<String, Integer> clinicCount = new HashMap<>();
        for (Paciente paciente : pacientes) {
            String clinic = paciente.darClinica();
            clinicCount.put(clinic, clinicCount.getOrDefault(clinic, 0) + 1);
        }
        int maxCount = 0;
        String mostOccupiedClinic = null;
        for (Map.Entry<String, Integer> entry : clinicCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostOccupiedClinic = entry.getKey();
            }
        }
        return mostOccupiedClinic;
    }

    private int darLongitud() {
        return pacientes.size();
    }
}
