package com.vtyurin.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries(
        @NamedQuery(name = "Category.findByParentId", query = "SELECT c from Category c where c.parentId = :id"))
public class Category extends BaseEntity {

    private String name;
    private String description;
    @Column(name = "PARENT_ID")
    private Long parentId;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<CategoryItemRelationship> categoryItemRelationship = new HashSet<>();

    public Category() {
    }

    public Category(String name) {
        this(name, 0);
    }

    public Category(String name, long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

//    public Category(String name, Category parent) {
//        this.name = name;
//        if (parent == null) {
//            this.parent = new NullCategory();
//        } else {
//            this.parent = parent;
//
//        }
//    }

//    private class NullCategory extends Category {
//
//        public NullCategory() {
//            this.setId((long) 0);
//            this.setParent(null);
//        }
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    //    public Category getParent() {
//        return parent;
//    }
//
//    public void setParent(Category parent) {
//        this.parent = parent;
//    }

    public Set<CategoryItemRelationship> getCategoryItemRelationship() {
        return categoryItemRelationship;
    }

    public void setCategoryItemRelationship(Set<CategoryItemRelationship> categoryItemRelationship) {
        this.categoryItemRelationship = categoryItemRelationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(description, category.description) &&
                Objects.equals(categoryItemRelationship, category.categoryItemRelationship) &&
                Objects.equals(parentId, category.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, parentId, categoryItemRelationship);
    }
}
