require 'rubygems'
require 'active_resource'

class Author < ActiveResource::Base
  self.site = 'http://localhost:8080/gmulibrary/'
  self.format =:json
  self.headers['Accept'] = 'application/json'


  AUTHORS = {}
 
  def self.setAuthors
    AUTHORS.clear
    @authors = self.find(:all)
    @authors.each do |author|
      AUTHORS[author.name] = author.id
    end
  end
 
  schema do
    integer 'id'
    string 'name', 'biography', 'dob', 'nationality', 'awards', 'image_url'
  end
end 
