package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.dto.LocacaoDTO;
import com.grupo04.Biblioteca.models.AlunoModel;
import com.grupo04.Biblioteca.models.LivroModel;
import com.grupo04.Biblioteca.models.LocacaoModel;
//import com.grupo04.Biblioteca.repository.AlunoRepository;
//import com.grupo04.Biblioteca.repository.LivroRepository;
import com.grupo04.Biblioteca.repository.LocacaoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/locacoes")
@Tag(name = "Locacao")
public class LocacaoController {

    @Autowired
    public LocacaoRepository locacaoRepository;

    //@Autowired
    //public AlunoRepository alunoRepository;

    //@Autowired
    //public LivroRepository livroRepository;

    //@GetMapping
    //public ResponseEntity<List<LocacaoDTO>> findAll() {
    //    List<LocacaoModel> list = locacaoRepository.findAll();
    //    List<LocacaoDTO> listDTO = new ArrayList<>();
//
    //    list.forEach(locacao -> {
    //        listDTO.add(new LocacaoDTO(
    //                locacao.getCdLocacao(),
    //                locacao.getAluno().getCdAluno(),
    //                locacao.getLivro().getCdLivro(),
    //                locacao.getDtLocacao(),
    //                locacao.getDtDevolucaoPrevista(),
    //                locacao.getDtDevolucaoReal(),
    //                locacao.getDsStatus()
    //        ));
    //     });
//
    //    return ResponseEntity.ok(listDTO);
    //}

    //@GetMapping("/{id}")
    //public ResponseEntity<?> findById(@PathVariable Long id) {
    //    try {
    //        LocacaoModel locacao = locacaoRepository.findById(id)
    //                .orElseThrow(() -> new InvalidParameterException("Locação inexistente!"));

    //        LocacaoDTO dto = new LocacaoDTO(
    //                locacao.getCdLocacao(),
    //                locacao.getAluno().getCdAluno(),
    //                locacao.getLivro().getCdLivro(),
    //                locacao.getDtLocacao(),
    //                locacao.getDtDevolucaoPrevista(),
    //                locacao.getDtDevolucaoReal(),
    //                locacao.getDsStatus()
    //        );

    //        return ResponseEntity.ok(dto);

    //    } catch (Exception e) {
    //        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    //    }
    //}

    //@PostMapping
    //public ResponseEntity<?> save(@RequestParam Long idAluno,
    //                              @RequestParam Long idLivro) {
    //   try {
    //        AlunoModel aluno = alunoRepository.findById(idAluno)
    //                .orElseThrow(() -> new InvalidParameterException("Aluno inexistente!"));
    //
    //        LivroModel livro = livroRepository.findById(idLivro)
    //                .orElseThrow(() -> new InvalidParameterException("Livro inexistente!"));
    //
    //        LocacaoModel nova = new LocacaoModel();
    //        nova.setAluno(aluno);
    //        nova.setLivro(livro);
    //        nova.setDtLocacao(LocalDateTime.now());
    //        nova.setDtDevolucaoPrevista(LocalDateTime.now().plusDays(7));
    //        nova.setDsStatus("EM_ABERTO");
    //
    //        locacaoRepository.save(nova);
    //
    //        return ResponseEntity.status(HttpStatus.CREATED).build();
    //
    //    } catch (Exception e) {
    //        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    //    }
    //  }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LocacaoModel locacaoBody) {
        try {
            LocacaoModel atual = locacaoRepository.findById(locacaoBody.getCdLocacao())
                    .orElseThrow(() -> new InvalidParameterException("Locação inexistente!"));

            atual.setDtDevolucaoPrevista(locacaoBody.getDtDevolucaoPrevista());
            atual.setDtDevolucaoReal(locacaoBody.getDtDevolucaoReal());
            atual.setDsStatus(locacaoBody.getDsStatus());
            locacaoRepository.save(atual);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/{atributo}")
    public ResponseEntity<?> patch(@PathVariable Long id,
                                   @PathVariable String atributo,
                                   @RequestParam String valor) {

        LocacaoModel locacao;

        try {
            locacao = locacaoRepository.findById(id)
                    .orElseThrow(() -> new InvalidParameterException("Locação inexistente!"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        try {
            switch (atributo) {
                case "status":
                    locacao.setDsStatus(valor);
                    break;
                case "devolucaoReal":
                    locacao.setDtDevolucaoReal(LocalDateTime.parse(valor));
                    break;
                default:
                    throw new InvalidParameterException("Atributo inválido!");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        locacaoRepository.save(locacao);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            locacaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
