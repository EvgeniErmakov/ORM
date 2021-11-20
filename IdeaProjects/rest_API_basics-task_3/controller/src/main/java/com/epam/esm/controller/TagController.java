package com.epam.esm.controller;

import com.epam.esm.dto.TagDTO;
import com.epam.esm.entity.Page;
import com.epam.esm.service.TagService;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.epam.esm.util.ResponseAssembler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tags")
@AllArgsConstructor
@Validated
public class TagController {

    private static final int MIN_ID = 1;
    private final TagService service;

    @GetMapping(value = "/{id}")
    public TagDTO findById(@PathVariable @Min(MIN_ID) Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<TagDTO> findAll(@Valid Page page) {
        return ResponseAssembler.assembleTags(service.findAll(page));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TagDTO create(@Valid @RequestBody TagDTO tagDTO) {
        return ResponseAssembler.assembleTag(service.create(tagDTO));
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Min(MIN_ID) Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/mostPopularTag")
    public TagDTO findMostPopular() {
        return ResponseAssembler.assembleTag(service.findMostPopularTag());
    }
}
