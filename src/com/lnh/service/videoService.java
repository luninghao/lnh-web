package com.lnh.service;

import com.lnh.model.Video;
import com.lnh.model.VideoLink;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class videoService {
    public static boolean uploadVideo(Video video) {
        return true;
    }

    public static List<VideoLink> displayVideo() {
        return new List<VideoLink>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<VideoLink> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(VideoLink videoLink) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends VideoLink> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends VideoLink> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public VideoLink get(int i) {
                return null;
            }

            @Override
            public VideoLink set(int i, VideoLink videoLink) {
                return null;
            }

            @Override
            public void add(int i, VideoLink videoLink) {

            }

            @Override
            public VideoLink remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<VideoLink> listIterator() {
                return null;
            }

            @Override
            public ListIterator<VideoLink> listIterator(int i) {
                return null;
            }

            @Override
            public List<VideoLink> subList(int i, int i1) {
                return null;
            }
        };
    }
}
