package com.truskappka.truskappka_backend.opinion.utils;

import com.truskappka.truskappka_backend.image.service.ImageService;
import com.truskappka.truskappka_backend.opinion.dto.OpinionAddForm;
import com.truskappka.truskappka_backend.opinion.dto.OpinionDto;
import com.truskappka.truskappka_backend.opinion.dto.Rating;
import com.truskappka.truskappka_backend.opinion.entity.Opinion;
import com.truskappka.truskappka_backend.tag.entity.Tag;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class OpinionMapper {

    public Opinion toOpinion(OpinionAddForm opinionAddForm) {
        return Opinion.builder()
                .uuid(UUID.randomUUID())
                .priceRating(opinionAddForm.rating().price())
                .qualityRating(opinionAddForm.rating().quality())
                .serviceRating(opinionAddForm.rating().service())
                .comment(opinionAddForm.comment())
                .build();
    }

    public static OpinionDto toOpinionDto(Opinion opinion, ImageService imageService) {
        List<String> imageUrls = opinion.getImageUrls() != null
                ? opinion.getImageUrls().stream()
                .map(imageService::getImageUrl)
                .toList()
                : List.of();

        return OpinionDto.builder()
                .uuid(opinion.getUuid())
                .rating(new Rating(
                        opinion.getQualityRating(),
                        opinion.getServiceRating(),
                        opinion.getPriceRating()
                ))
                .comment(opinion.getComment())
                .tags(opinion.getTags().stream().map(Tag::getName).toList())
                .images(imageUrls)
                .build();
    }
}
