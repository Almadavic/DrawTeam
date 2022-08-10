package application.controller.resource;

import application.dto.request.MatchRequestDTO;
import application.dto.response.MatchResponseDTO;
import application.service.serviceAction.PlayMatchService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/playmatch")
public class PlayMatchController {  // Controller onde inicia a partida.

    @Autowired
    private PlayMatchService playMatchService;

    @PostMapping(value = "")
    @Operation(summary = "Faz o sorteio dos times.")
    public ResponseEntity<MatchResponseDTO> run(@RequestBody @Valid MatchRequestDTO matchForm,         // END-POINT onde acontece toda a lógica da API ( SORTEIO ).
                                                @RequestParam(required = false, value = "drawgoalkeeper") String drawGoalkeeper) {

        MatchResponseDTO matchDTO = playMatchService.run(matchForm, drawGoalkeeper);

        return ResponseEntity.ok().body(matchDTO);
    }

}
