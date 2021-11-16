/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:31 PM
 *   File: AnnouncementRepository.java
 */

package com.example.gurukul.repository;

import com.example.gurukul.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement,Integer> {

    Announcement findAnnouncementById(int id);
}