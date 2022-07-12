package org.example.services;

import org.example.common.IDConverter;
import org.example.models.LongUrl;
import org.example.repositories.LongUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLConverterService {
    private final LongUrlRepository urlRepository;

    @Autowired
    public URLConverterService(LongUrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenURL(String localURL, String longUrl) {
        LongUrl url = new LongUrl(longUrl);
        LongUrl newUrl = urlRepository.save(url);
        return formatLocalURLFromShortener(localURL) + newUrl.getId();
    }

    public String getLongURLFromID(String uniqueID) throws Exception {
        Long dictionaryKey = IDConverter.INSTANCE.getDictionaryKeyFromUniqueID(uniqueID);

        long idLong = Long.parseLong(uniqueID);
        Optional<LongUrl> byId = urlRepository.findById(idLong);
        return byId.get().getUrl();
    }

    private String formatLocalURLFromShortener(String localURL) {
        String[] addressComponents = localURL.split("/");
        // remove the endpoint (last index)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < addressComponents.length - 1; ++i) {
            sb.append(addressComponents[i]);
        }
        sb.append('/');
        return sb.toString();
    }

}