package com.desafio.picpay.transacao;

import com.desafio.picpay.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transacaos")
@Table(name = "transcaos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Usuario remetente;
    @ManyToOne
    @JoinColumn(name = "receptor_id")
    private Usuario receptor;
    private LocalDateTime dataHoraDaTransacao;

}
