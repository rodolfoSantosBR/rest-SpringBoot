package br.com.rodolfo.api.transaction.controller;


import br.com.rodolfo.api.transaction.data.vo.v1.PersonVO;
import br.com.rodolfo.api.transaction.model.Person;
import br.com.rodolfo.api.transaction.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/person")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PersonController {

    @Autowired
    private PersonServices service;
    @GetMapping(
            produces = { "application/json", "application/xml", "application/yml" })
    @Operation(summary = "Finds all People!!", description = "Finds all People",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = { "application/json", "application/xml", "application/yml"  })
    @Operation(summary = "Finds a Person!!", description = "Finds a Person",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @CrossOrigin(origins = "http://localhost:8888")
    public Person findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            produces = { "application/json", "application/xml", "application/yml"  })
    @Operation(summary = "Creates a Person!!", description = "Creates a Person",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )

    @CrossOrigin(origins = {"http://localhost:8888", "https://erudio.com.br" } )
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping(
            consumes = { "application/json", "application/xml", "application/yml"   },
            produces = { "application/json", "application/xml", "application/yml"  })
    @Operation(summary = "Updates a Person!!",
            description = "Updates a Person by passing in a JSON, XML or YML representation of the person!",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }


    @PatchMapping(value = "/{id}",
            consumes = { "application/json", "application/xml", "application/yml"   },
            produces = { "application/json", "application/xml", "application/yml"  })
    @Operation(summary = "Updates a Person!!",
            description = "Updates a Person by passing in a JSON, XML or YML representation of the person!",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public PersonVO enablePerson(@PathVariable(value = "id") Long id) {
        return service.disablePerson(id);
    }




    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletes a Person!!",
            description = "Deletes a Person by passing in a JSON, XML or YML representation of the person!",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}