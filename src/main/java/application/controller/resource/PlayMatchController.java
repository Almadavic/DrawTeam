package application.controller.resource;

import application.dto.request.MatchRequestDto;
import application.dto.response.MatchResponseDto;
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
    public ResponseEntity<MatchResponseDto> run(@RequestBody @Valid MatchRequestDto matchForm,         // END-POINT onde acontece toda a lógica da API ( SORTEIO ).
                                                @RequestParam(required = false) String drawGoalkeeper) {

        MatchResponseDto matchDto = playMatchService.run(matchForm, drawGoalkeeper);

        return ResponseEntity.ok().body(matchDto);
    }

}
