package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.ClienteDTO;

public class ClienteDTOFactory {
    public static ClienteDTO registraDTOValido() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNome("José");
        return cliente;
    }

    public static ClienteDTO registraDTOValidoComID() {
        ClienteDTO cliente = new ClienteDTO();
        cliente = ClienteDTOFactory.registraDTOValido();
        cliente.setId("001");

        return cliente;
    }
}
