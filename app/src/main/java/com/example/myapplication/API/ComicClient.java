package com.example.myapplication.API;

import com.example.myapplication.Model.ComicDTO;
import com.example.myapplication.Model.ComicsDTO;
import com.example.myapplication.Model.ComicsQuery;
import com.example.myapplication.Model.Response;

import java.util.Map;

import retrofit2.Call;

public final class ComicClient extends APIClient {

    public ComicClient(APIConfig apiConfig) {
        super(apiConfig);
    }

    public Response<ComicsDTO> getAll(int offset, int limit) throws ApiException {

        ComicsQuery comicsQuery = ComicsQuery.Builder.create().getAndSetOffset(offset).getAndSetLimit(limit).build();
        return getAll(comicsQuery);
    }

    private Response<ComicsDTO> getAll(ComicsQuery comicsQuery) throws ApiException {
        Map<String, Object> queryMap = comicsQuery.toMap();
        ComicREST comicREST = getApi(ComicREST.class);
        Call<Response<ComicsDTO>> call = comicREST.getComics(queryMap);
        return executar(call);
    }

    public Response<ComicDTO> getComic(String idComic) throws ApiException {
        if (idComic == null || idComic.isEmpty()) {
            throw new IllegalArgumentException("idComic nao pode ser nulo");
        }
        ComicREST comicREST = getApi(ComicREST.class);
        Call<Response<ComicsDTO>> call = comicREST.getComic(idComic);
        Response<ComicsDTO> resComics = executar(call);
        ComicsDTO comicsDTO = resComics.getResponse();
        if (comicsDTO != null) {
            ComicDTO comicDTO = comicsDTO.getComics().get(0);
            Response<ComicDTO> resComic = new Response<>(resComics);
            resComic.setResponse(comicDTO);
            return resComic;
        } else {
            throw new ApiException("comic nao encontrada", null);
        }
    }
}
