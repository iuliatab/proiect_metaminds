package org.tablet.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tablet.persistence.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}