class UsersController < ApplicationController

  def new
    @user = User.new
  end
  
  def create
    @user = User.new(user_params)
    if @user.save
      redirect_to sessions_path, notice: "User #{@user.user_id} saved successfully!"
    else
      render 'new'
    end

  end

  private

  def user_params
    params.require(:user).permit(:name, :user_id, :password, :password_confirmation, :admin)
  end

end

