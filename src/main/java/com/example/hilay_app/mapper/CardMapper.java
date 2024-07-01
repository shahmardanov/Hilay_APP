package com.example.hilay_app.mapper;


import com.example.hilay_app.entity.Card;
import com.example.hilay_app.request.create.CardCreateRequest;
import com.example.hilay_app.request.update.CardUpdateRequest;
import com.example.hilay_app.response.create.CardCreateResponse;
import com.example.hilay_app.response.read.CardReadResponse;
import com.example.hilay_app.response.update.CardUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CardMapper {

    Card cardCreateRequestToCard(CardCreateRequest cardCreateRequest);

    CardCreateResponse cardToCardCreateResponse(Card card);




    CardReadResponse cardToCardReadResponse(Card card);

    CardUpdateResponse cardToCardUpdateResponse(Card card);
    void updateCardFromRequest(@MappingTarget Card card, CardUpdateRequest cardUpdateRequest);
}


