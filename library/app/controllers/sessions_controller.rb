class SessionsController < ApplicationController

  def new
  end

  def create
    user = User.find_by(user_id: params[:user_id])
    if user and user.authenticate(params[:password])
      session[:user_id] = user.id
      session[:admin] = user.admin
      redirect_to books_url, notice: "Welcome back #{user.name}"
    else
      redirect_to sessions_url, notice: "Invalid user name or password"
    end
  end

  def destroy
    session[:user_id] = nil
    session[:admin] = nil
    redirect_to sessions_url, notice: "You are now logged out"
  end

end
