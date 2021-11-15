package io.github.edsontofolo.springbootjpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplementoAnuarioDto {
    private Integer id;
    private String texto;
    private String url;
    private List<ComplementoAnuarioRamoUrlDto> complementoAnuarioRamoUrls;
}
