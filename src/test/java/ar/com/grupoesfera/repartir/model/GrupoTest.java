package ar.com.grupoesfera.repartir.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GrupoTest {

    @Test
    void crearSinParametros() {

        Grupo grupo = new Grupo();

        assertThat(grupo.getId()).isNull();
        assertThat(grupo.getNombre()).isNull();
        assertThat(grupo.getMiembros()).isNull();
        assertThat(grupo.getTotal()).isNull();
    }

    @Test
    void crearConId() {

        final Long ID = 153L;
        Grupo grupo = new Grupo(ID);

        assertThat(grupo.getId()).isEqualTo(ID);
        assertThat(grupo.getNombre()).isNull();
        assertThat(grupo.getMiembros()).isNull();
        assertThat(grupo.getTotal()).isNull();
    }

    @Test
    void noEstaFormadoCuandoTieneSoloUnMiembro() {

        Grupo grupo = new Grupo();
        grupo.setMiembros(Arrays.asList("martin"));

        boolean estaFormado = grupo.estaFormado();

        assertThat(estaFormado).isFalse();
    }

    @Test
    void estaFormadoCuandoTieneDosMiembros() {

        Grupo grupo = new Grupo();
        grupo.setMiembros(Arrays.asList("mtolosa", "sdiaz"));

        boolean estaFormado = grupo.estaFormado();

        assertThat(estaFormado).isTrue();
    }

    @Test
    void noEstaFormadoCuandoLosMiembrosSonNulos() {

        Grupo grupo = new Grupo();

        grupo.setMiembros(null);

        assertThat(grupo.estaFormado()).isFalse();
    }

    //consigna anterior, agregar un test cualquiera
    @Test
    void cantidadDeMiembrosCorrectaAlAgregarMiembros() {
        Grupo grupo = new Grupo();
        String [] miembros = {"Pepe Grillo","Pep Guardiola","Pipino Cuevas"};
        grupo.setMiembros(List.of(miembros));
        assertThat(grupo.getMiembros().size()).isEqualTo(3);
    }
    @Test
    void noEstaFormadoCuandoElNombreEsUnSoloCaracter() {

        Grupo grupo = new Grupo();
        grupo.setMiembros(Arrays.asList("martin"));
        grupo.setNombre("A");
        boolean estaFormado = grupo.estaFormado();

        assertThat(estaFormado).isFalse();

    }

}
