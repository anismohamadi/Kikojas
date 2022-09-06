package krd.kurdestansoft.showin.place;

import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/place")
@AllArgsConstructor
public class PlaceController {

    private final PlaceService service;
    private final PlaceMapper mapper;


  @PostMapping(value = "/v1")
  public ResponseEntity Save(@RequestBody PlaceDTO placeDTO){
      Place place=mapper.toPlace((placeDTO));
      service.save(place);
      return ResponseEntity.status(HttpStatus.CREATED).build();
  }

    @GetMapping(value = "/v1")
    public ResponseEntity<List<PlaceDTO>> getAll()
    {

        List<Place> places=service.getAll();
        List<PlaceDTO> placeDTOS = mapper.toPlaceDTOS(places);
        return ResponseEntity.ok(placeDTOS);

    }

    @GetMapping("/v1/{id}")

    public ResponseEntity<PlaceDTO> getById(@PathVariable Long id ){
        Place place = service.getById(id);
        PlaceDTO placeDTO =mapper.toPlaceDTO(place);
        return ResponseEntity.ok(placeDTO);
    }


    @GetMapping(value = "/v1/{lat}/{lng}/{distance}")

    public ResponseEntity<List<PlaceDTO>> findNearestByDistance(@PathVariable(name = "lat") double lat,@PathVariable(name = "lng") double lng,@PathVariable(name = "distance") double distance)
    {

        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);
        List<Place> places = service.findNearest(candidPoint,distance);
        List<PlaceDTO> placesDTO = mapper.toPlaceDTOS(places);
        return ResponseEntity.ok(placesDTO);

    }





}
